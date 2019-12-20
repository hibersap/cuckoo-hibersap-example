FROM jboss/wildfly:18.0.1.Final

USER root

COPY wildfly/add-resource-adapter.cli /opt/jboss/config/
COPY wildfly/modules/sap-jco/module.xml /opt/jboss/wildfly/modules/com/sap/sap-jco/main/
COPY target/dependency/com.sap.conn.jco.sapjco3.jar /opt/jboss/wildfly/modules/com/sap/sap-jco/main/sapjco3.jar
COPY target/dependency/com.sap.conn.jco.sapjco3-linuxx86_64.so /opt/jboss/wildfly/modules/com/sap/sap-jco/main/lib/linux-x86_64/libsapjco3.so

ARG WAR_FILE
ADD target/${WAR_FILE} /opt/jboss/wildfly/standalone/deployments/
ADD target/dependency/cuckoo-rar.zip /opt/jboss/wildfly/standalone/deployments/cuckoo-rar.rar

RUN /opt/jboss/wildfly/bin/add-user.sh admin secret+2019 --silent && \
    /bin/sh /opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/config/add-resource-adapter.cli && \
    rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history && \
    chown -R jboss:jboss /opt/jboss/wildfly/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]