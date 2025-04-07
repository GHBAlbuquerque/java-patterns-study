#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#       SENDING MESSAGE       #"
echo "###############################"

message=$(cat MESSAGE_FILE_PATH)

echo $message

aws sqs send-message --endpoint-url "$ENDPOINT_URL" \
  --queue-url "$QUEUE_URL" \
  --message-body "$message" \
  --region us-east-1

echo "###############################"
echo "#         MESSAGE SENT        #"
echo "###############################"

read -p "Press enter to quit..."