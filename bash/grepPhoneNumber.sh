#!/bin/bash

while IFS= read -r line;do
  s=`echo $line | grep -P '(\d{3}-|\(\d{3}\)\s)\d{3}-\d{4}' -o`
  if [[ "$s" == "$line" ]]
  then
    echo $line
  fi
done < $1