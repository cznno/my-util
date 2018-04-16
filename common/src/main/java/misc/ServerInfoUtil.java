package misc;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by cznno
 * Date: 18-4-16
 */
public class ServerInfoUtil {

    /**
     * 获取服务器的访问地址
     *
     * @return 服务器的访问地址 如http://127.0.0.1:8080
     * @link {https://stackoverflow.com/questions/3867197/get-the-server-port-number-from-tomcat-without-a-request}
     */
    List<String> getEndPoints() throws MalformedObjectNameException, UnknownHostException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        QueryExp subQuery1 = Query.match(Query.attr("protocol"), Query.value("HTTP/1.1"));
        QueryExp subQuery2 = Query.anySubString(Query.attr("protocol"), Query.value("Http11"));
        QueryExp query = Query.or(subQuery1, subQuery2);
        Set<ObjectName> objs = mbs.queryNames(new ObjectName("*:type=Connector,*"), query);
        String hostname = InetAddress.getLocalHost().getHostName();
        InetAddress[] addresses = InetAddress.getAllByName(hostname);
        ArrayList<String> endPoints = new ArrayList<>();
        /*
        for (Iterator<ObjectName> i = objs.iterator(); i.hasNext();) {
            ObjectName obj = i.next();
            ...
        }
         */
        for (ObjectName obj : objs) {
            String scheme = mbs.getAttribute(obj, "scheme").toString();
            String port = obj.getKeyProperty("port");
            for (InetAddress addr : addresses) {
//                if (addr.isAnyLocalAddress() || addr.isLoopbackAddress() ||
//                        addr.isMulticastAddress()) {
//                    continue;
//                }
                String host = addr.getHostAddress();
                String ep = scheme + "://" + host + ":" + port;
                endPoints.add(ep);
            }
        }
        return endPoints;
    }
}
