#!/bin/sh

# This script sets up the environment for the local development of the project.

export SQS_NAME="payment-update-queue"
export ENDPOINT_URL="http://localhost:4566"
export QUEUE_URL="$ENDPOINT_URL/000000000000/$SQS_NAME"
export QTT_TO_RECEIVE="10"
export MESSAGE_FILE_PATH="./message.json"

echo "###############################"
echo "#     IMPORTING VARIABLES     #"
echo "###############################"
echo "SQS_NAME: $SQS_NAME"
echo "ENDPOINT_URL: $ENDPOINT_URL"
echo "QUEUE_URL: $QUEUE_URL"
echo "QTT_TO_RECEIVE: $QTT_TO_RECEIVE"
echo "MESSAGE_FILE_PATH: $MESSAGE_FILE_PATH"