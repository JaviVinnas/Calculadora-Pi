
import subprocess

def get_args():
    return {
        "InterfazRemota": {"cliente": True, "servidor": True, "stubskel": False},
        "InterfazRemotaImpl": {"cliente": False, "servidor": True, "stubskel": True},
        "MainCliente": {"cliente": True, "servidor": False, "stubskel": False},
        "MainServidor": {"cliente": False, "servidor": True, "stubskel": False},
    }



if __name__ == "__main__":

    #borramos las carpetas servidor y cliente y los archivos .class del directorio principal
    for command in ["rm -r ./Servidor", "rm -r ./Cliente"]:
        subprocess.run(command, shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)

    #creamos otra vez las carpetas
    for command in ["mkdir Servidor", "mkdir Cliente"]:
        subprocess.run(command, shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)
    
    #compilamos todo nuevamente
    subprocess.run("javac ./*.java", shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)

    for key, value in get_args().items():
        if value["InterfazRemota"]:
            #generamos el skeleton y stub
            subprocess.run("rmic -v1.1 {0}".format(key), shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)
            #metemos el skeleton en el servidor y el stub en el cliente
            subprocess.run("mv ./{0}_Stub.class ./Cliente".format(key), shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)
            subprocess.run("mv ./{0}_Skel.class ./Servidor".format(key), shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)
        if value["cliente"]:
            subprocess.run("cp ./{0}.class ./Cliente/".format(key), shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)
        if value["servidor"]:
            subprocess.run("cp ./{0}.class ./Servidor/".format(key), shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)
        #lo eliminamos del directorio principal
        subprocess.run("rm {0}.class".format(key), shell=True, check=True, stdout=subprocess.PIPE, universal_newlines=True)

