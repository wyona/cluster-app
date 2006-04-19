

Preparations:
-------------
cp build.properties local.build.properties
Edit local.build.properties


Build/Install:
--------------
ant resp. ant install


Run:
----
Startup Servlet Container (e.g. Tomcat)
Browse to http://127.0.0.1:8080/cluster/


Misc:
-----
http://www.onjava.com/pub/a/onjava/2004/04/14/clustering.html
http://www.onjava.com/pub/a/onjava/2004/11/24/replication1.html
http://tomcat.apache.org/tomcat-5.0-doc/balancer-howto.html
http://tomcat.apache.org/tomcat-5.0-doc/cluster-howto.html
http://docs.sun.com/source/819-0215/loadb.html

http://www.josso.org/
http://rabbit-proxy.sourceforge.net/index.shtml
http://www.me.lv/jp/


Developer Notes:
----------------

To make objects seriazable/replicable/clusterable one needs to implement the methods

writeObject

and 

readObject

See for instance: http://svn.apache.org/repos/asf/lenya/branches/BRANCH_1_2_X/src/java/org/apache/lenya/ac/Identity.java
