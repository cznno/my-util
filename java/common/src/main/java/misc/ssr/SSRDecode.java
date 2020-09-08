package misc.ssr;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cznno
 * Date: 18-4-13
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class SSRDecode {

    private static final Pattern SSR_URL_PATTERN = Pattern.compile("((ssr)?://)[^\\s]+");
    private static final Pattern SSR_URL_CONTENT_PATTERN = Pattern.compile("(?<=ssr://)[^\\s]+");
    private static final Pattern SPLIT_PATTERN_1 = Pattern.compile(":");
    private static final Pattern SPLIT_PATTERN_2 = Pattern.compile("&");
    private static final Pattern PARAM_PATTERN = Pattern.compile("(?<==).+");

    public static void main(String[] args) throws IOException {

        final String file = readFile(args[0]);
        final String fileStr = decode(file);
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        Matcher ssrUrlMatcher = SSR_URL_PATTERN.matcher(fileStr);
        final SSR ssr = new SSR();
        while (ssrUrlMatcher.find()) {
            String ssrUrl = ssrUrlMatcher.group().replace("_", "/");

            Matcher ssrUrlContentMatcher = SSR_URL_CONTENT_PATTERN.matcher(ssrUrl);
            if (!ssrUrlContentMatcher.find())
                continue;
            final String ssrUrlContent = decode(ssrUrlContentMatcher.group());

            final int separator = ssrUrlContent.indexOf("/?");
            final String baseDataEncoded = ssrUrlContent.substring(0, separator);
            final String substring2 = ssrUrlContent.substring(separator + 2);


            final String[] baseDataEncodedArray = SPLIT_PATTERN_1.split(baseDataEncoded);
            ssr.setServer(baseDataEncodedArray[0]);
            ssr.setServerPort(Integer.valueOf(baseDataEncodedArray[1]));
            ssr.setProtocol(baseDataEncodedArray[2]);
            ssr.setMethod(baseDataEncodedArray[3]);
            ssr.setObfs(baseDataEncodedArray[4]);
            ssr.setPassword(decode(baseDataEncodedArray[5]));

            final String[] split1 = SPLIT_PATTERN_2.split(substring2);

            ssr.setObfsParam(getDataDecoded(split1[0]));
            ssr.setProtocolParam(getDataDecoded(split1[1]));
            ssr.setRemarks(getDataDecoded(format(split1[2])));
            ssr.setGroup(getDataDecoded(format(split1[3])));
            System.out.println(ssr);
            writer.write(ssr.toString() + "\n");
        }
        writer.close();
    }

    private static String format(String s1) {
        String s = s1.replace("-", "+");
        return s.replace("_", "/");
    }

    private static String getDataDecoded(String s) throws UnsupportedEncodingException {
        final Matcher m = PARAM_PATTERN.matcher(s);
        if (!m.find())
            return null;
        final String group2 = m.group();
        return decode(group2);
    }

    private static String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return new String(data, "UTF-8");
    }

    private static String decode(String stringEncoded) throws UnsupportedEncodingException {
        final byte[] decodeBytes = Base64.getDecoder().decode(stringEncoded);
        return new String(decodeBytes, StandardCharsets.UTF_8.name());
    }
}
