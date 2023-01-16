# Studentjob-tfg
Repository that includes the Liferay workspace corresponding to the computer engineering degree final project, which consists of the development of a job portal for UOC students

## Importació en Local

Per aixecar el portal en un entorn local es pot utilitzar el docker definit en el docker-compose.yml en l'arrel del projecte per aixecar el servidor de MySQL. La resta de serveis (liferay i elasticsearch) s'han mogut al fitxer docker-compose-complete.yml

Cal importar la base de dades exportada de producció en l'entorn de Docker MySQL. Ens connectem amb un gestor de MySQL i la importem (root / password)
https://mega.nz/file/fJ5nmTbY#GzL9_pcU8N4Tj6HeuTx8To4Vpj6iO2XUz2b00GFLAUo

Cal descarregar el Liferay amb Tomcat integrat per poder aixecar el portal en local. Un cop descomprimit cal tocar el fitxer de l'arrel **portal-setup-wizard.properties** per canviar la propietat **liferay.home** per la ruta on es troba el Liferay. En cas de ser Windows ha de ser quelcom com: 
C:/Liferay/TFG/liferay-ce-portal-7.4.3.46-ga46

Aquesta versió ja té els mòduls instal·lats (osgi/war i osgi/modules)
https://mega.nz/file/7FRAwa5A#s0xzMaBB3DwwIVTbBcQCbfe4RH9FYoGpJTl6Eqne4lY

Vídeotutorial d'instal·lació en local. En instal·larlo tindrem una còpia idèntica a l'entorn de Producció, amb els mateixos usuaris i contingut. També tindrà configurat el servidor de correu.
https://www.youtube.com/watch?v=LMDAt9r8BFI

## Credits

- E-mails templates based on templates available on : https://codedmails.com/
- Stock images from ShutterStock : https://www.shutterstock.com/
- Company content fake logos from UiLogos : https://uilogos.co/
