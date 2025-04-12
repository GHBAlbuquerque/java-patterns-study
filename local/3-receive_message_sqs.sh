#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#     RECEIVEING MESSAGE      #"
echo "###############################"

aws sqs receive-message --endpoint-url "$ENDPOINT_URL" \
  --queue-url "$UPDATE_QUEUE_URL" \
  --attribute-names All \
  --message-attribute-names All \
  --max-number-of-messages "$QTT_TO_RECEIVE"

echo "###############################"
echo "#      MESSAGE RECEIVED       #"
echo "###############################"

read -p "Press enter to quit..."