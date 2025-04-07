#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#     STARTING LOCALSTACK     #"
echo "###############################"

docker-compose up -d --build

echo "###############################"
echo "#      CREATING QUEUE         #"
echo "###############################"

aws sqs create-queue \
  --queue-name "$SQS_NAME" \
  --endpoint-url "$ENDPOINT_URL" \
  --region us-east-1

echo "###############################"
echo "#   QUEUE $SQS_NAME CREATED   #"
echo "###############################"
read -p "Press enter to quit..."