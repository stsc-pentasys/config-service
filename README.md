# Running *configservice* under Windows

## Build
Due to a bug in version *1.0.1.RELEASE* of `spring-cloud-config-server` it is necessary to build the module
against a snapshot version until *1.0.2.RELEASE* is available (see property `spring.cloud.version` in *pom.xml*).
Simply create a runnable artifact *target/configservice-0.0.1-SNAPSHOT.jar* with `mvn install`.

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
