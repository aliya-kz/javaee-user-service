FROM tomcat
WORKDIR /app
COPY . .
EXPOSE 8080

CMD ["/opt/tomcat/bin/catalina.sh", "run"]
