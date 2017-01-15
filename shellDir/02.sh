#!/bin/sh
/bin/date +%F >> /Users/tao/git/java-architect-practice/shellDir/02.info
echo "disk info:" >> /Users/tao/git/java-architect-practice/shellDir/02.info
/bin/df -h >>/Users/tao/git/java-architect-practice/shellDir/02.info
echo >> /Users/tao/git/java-architect-practice/shellDir/02.info
echo "online users:" >> /Users/tao/git/java-architect-practice/shellDir/02.info
#/usr/bin/who | /bin/grep -v root >> /Users/tao/git/java-architect-practice/shellDir/02.info
echo "memory info:" >> /Users/tao/git/java-architect-practice/shellDir/02.info
#/usr/bin/free -m >> /Users/tao/git/java-architect-practice/shellDir/02.info
echo >> /Users/tao/git/java-architect-practice/shellDir/02.info
#write root
#/usr/bin/write root < /Users/tao/git/java-architect-practice/shellDir/02.info && /bin/rm /Users/tao/git/java-architect-practice/shellDir/02.info
#crontab -e
#0 9 * * 1-5 /bin/sh//Users/tao/git/java-architect-practice/shellDir/02.sh