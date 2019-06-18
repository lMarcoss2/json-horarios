docker stop calc-beca-services-container
docker rm calc-beca-services-container
docker build -t calc-beca-services .
#docker run --env-file bd.env -d -p 3311:3306 --name calc-beca-container calc-beca
docker run -dt -p 8181:8182 --name calc-beca-services-container calc-beca-services
docker start calc-beca-services-container
