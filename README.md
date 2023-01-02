# studentjob-tfg
Repository that includes the Liferay workspace corresponding to the computer engineering degree final project, which consists of the development of a job portal for UOC students

Per aixecar el portal en un entorn local es pot utilitzar el docker definit en el docker-compose.yml en l'arrel del projecte per aixecar el servidor de MySQL. La resta de serveis (liferay i elasticsearch) no fan falta i es poden eliminar.

Cal importar la base de dades exportada de producció en l'entorn de Docker MySQL. Ens connectem amb un gestor de MySQL i la importem (root / password)
https://mega.nz/file/fJ5nmTbY#GzL9_pcU8N4Tj6HeuTx8To4Vpj6iO2XUz2b00GFLAUo

Cal descarregar el Liferay amb Tomcat integrat per poder aixecar el portal en local. Un cop descomprimit cal tocar el fitxer portal-setup-wizard.properties per canviar la propietat liferay.home per la ruta on es troba el Liferay. En cas de ser Windows ha de ser quelcom com: 
C:/Liferay/TFG/liferay-ce-portal-7.4.3.46-ga46
