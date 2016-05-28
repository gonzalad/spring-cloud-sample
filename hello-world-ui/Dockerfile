FROM gonzalad/docker-node

USER root 

# copy sources
COPY . /home/jhipster/app

RUN \

  # install jhipster
  #npm install -g /home/jhipster/generator-jhipster && \

  # fix jhipster user permissions
  #chown -R jhipster:jhipster \
  #  /home/jhipster \
  #  /usr/lib/node_modules && \

  #install dependencies
  npm install && \

  # Run our app when the container is run
  npm run build:prod && \
  
  # cleanup
  apt-get clean && \
  rm -rf \
    /var/lib/apt/lists/* \
    /tmp/* \
    /var/tmp/* && \

  # fix jhipster user permissions
  chown -R jhipster:jhipster \
         /home/jhipster/app 

USER jhipster

# expose the working directory, the Tomcat port, the BrowserSync ports
EXPOSE 8080 

# run web server
CMD ["npm", "run", "server:prod"]
