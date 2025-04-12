#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#       SENDING MESSAGE       #"
echo "###############################"

message=$(cat $MESSAGE_FILE_PATH)

echo $message

aws sqs send-message --endpoint-url "$ENDPOINT_URL" \
  --queue-url "$PAYMENT_QUEUE_URL" \
  --message-body "$message"

echo "###############################"
echo "#         MESSAGE SENT        #"
echo "###############################"

read -p "Press enter to quit..."