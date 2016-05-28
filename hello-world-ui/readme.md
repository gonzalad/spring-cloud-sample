# Build

See package.json. I'm using webpack : https://github.com/AngularClass/angular2-webpack-starter


# development

npm run server (not so sure now that I'm using docker).


# production

npm run build:prod
npm run server:prod


# using Docker

## build docker image

docker build -t gonzalad/hello-world-ui .

## run containers

docker run -d --name hello-world-service -p 8080:8080 gonzalad/hello-world-service
docker run -d --name hello-world-ui -p 8081:8080 gonzalad/hello-world-ui

open a browser on http://localhost:8081

## Notes

### see what's inside a running container

docker exec -i -t hello-world-ui /bin/bash


