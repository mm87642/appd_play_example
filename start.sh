cp -r ../appd_play_example /vol/appd_play_example
cp -r /vol/appd_play_example/AppDynamics /vol/AppDynamics
cd /vol/appd_play_example
chmod +x ./activator
sudo kill -9 $(pgrep -f "/vol/appd_play_example")
rm -f /vol/appd_play_example/RUNNING_PID
rm -rf appd_play_example-1.0-SNAPSHOT
./activator clean dist  && unzip target/universal/*.zip
cd appd_play_example-1.0-SNAPSHOT
nohup sudo ./bin/appd_play_example -J-javaagent:/vol/AppDynamics/javaagent.jar -Djdk.tls.rejectClientInitiatedRenegotiation=true -Djdk.tls.ephemeralDHKeySize=2048 -Duser.dir=/vol/appd_play_example -Dlogger.file=/vol/appd_play_example/conf/logger.xml &
