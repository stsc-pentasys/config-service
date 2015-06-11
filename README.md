# Running *configservice* under Windows

## Build
Due to a bug in version *1.0.1.RELEASE* of `spring-cloud-config-server` it is necessary to build the module
against a snapshot version until *1.0.2.RELEASE* is available (see property `spring.cloud.version` in *pom.xml*).
Simply create a runnable artifact *target/configservice-0.0.1-SNAPSHOT.jar* with `mvn install`.

## Install root certificate
The central GiT-Service *sot-vgit-01p.int.diraba.de* is secured using a self-signed certificate. Spring Cloud Config
blocks access to sites with unknown root certificates at the top of the certificate chain. Therefore the certificate
issued by DAB Ops must be installed in your local JVMs keystore. Just follow these steps:
1. Locate the folder *libs/security* in the JVM installation used to run *configserver*.
2. Copy *src/test/resources/sysinfraca2.cer* to *libs/security*.
3. Import the root certificate into the *cacerts* keystore:
`keytool -import -alias sysinfraca2  -keystore cacerts -file sysinfraca2.cer`
4. On prompt choose a new password for the keystore
5. Enter 'Yes'/'Ja'.

## Configuration
You may change the default ports (9090/9091) and the location of the local repository basedir
by providing a *application.yml* (or *application.properties*) in the services installation directory.
See default configuration in *src/main/resources/application.yml*.

## Command-line arguments
*configserver* needs some command line arguments for proper operation:
* Suppress Server Name Indication in SSL handshake with `-Djsse.enableSNIExtension=false`
* Provide a valid GiT user's login name with option `--git.username`
* Provide the correct password with option `--git.password`

e.g. `java -jar -Djsse.enableSNIExtension=false configservice-0.0.1-SNAPSHOT.jar --git.username=dacrashtest --git.password=default`

## Test
Try some of the following links in your browser:
- [YAML](http://localhost:9090/master/contentprovider-production.yaml)
- [JSON](http://localhost:9090/master/contentprovider-production.json)
- [Properties](http://localhost:9090/master/contentprovider-production.properties)
- [Default JSON resource](http://localhost:9090/contentprovider/production/master)
- [Alternative profile](http://localhost:9090/master/contentprovider-development.yaml)
- [Second application](http://localhost:9090/master/sessionmanager-development.yaml)
