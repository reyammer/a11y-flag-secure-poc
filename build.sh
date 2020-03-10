#!/bin/bash

set -x
set -e

cd Victim
./gradlew build
cd -

cp ./Victim/app/build/outputs/apk/release/app-release-unsigned.apk ./apks/victim.apk
sign_apk.sh ./apks/victim.apk
