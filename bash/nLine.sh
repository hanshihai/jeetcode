#!/bin/bash

n=`cat file.txt | wc -l`

if [ $n -gt $1 ]
then
    head -$1 file.txt | tail -1
fi