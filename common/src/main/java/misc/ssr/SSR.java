package misc.ssr;

/**
 * Created by cznno
 * Date: 18-4-13
 */
public class SSR {

    private String server;
    private Integer serverPort;
    private String method;
    private String group;
    private String obfs;
    private String obfsParam;
    private String remarksBase64;
    private String password;
    private String protocol;
    private String protocolParam;
    private String remarks;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getObfs() {
        return obfs;
    }

    public void setObfs(String obfs) {
        this.obfs = obfs;
    }

    public String getObfsParam() {
        return obfsParam;
    }

    public void setObfsParam(String obfsParam) {
        this.obfsParam = obfsParam;
    }

    public String getRemarksBase64() {
        return remarksBase64;
    }

    public void setRemarksBase64(String remarksBase64) {
        this.remarksBase64 = remarksBase64;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocolParam() {
        return protocolParam;
    }

    public void setProtocolParam(String protocolParam) {
        this.protocolParam = protocolParam;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "{" + "\"server\":\"" +
                server + '\"' +
                ",\"serverPort\":" +
                serverPort +
                ",\"method\":\"" +
                method + '\"' +
                ",\"group\":\"" +
                group + '\"' +
                ",\"obfs\":\"" +
                obfs + '\"' +
                ",\"obfsParam\":\"" +
                obfsParam + '\"' +
                ",\"remarksBase64\":\"" +
                remarksBase64 + '\"' +
                ",\"password\":\"" +
                password + '\"' +
                ",\"protocol\":\"" +
                protocol + '\"' +
                ",\"protocolParam\":\"" +
                protocolParam + '\"' +
                ",\"remarks\":\"" +
                remarks + '\"' +
                '}';
    }
}
