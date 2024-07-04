FROM airhacks/glassfish
COPY ./target/javaee-test.war ${DEPLOYMENT_DIR}
