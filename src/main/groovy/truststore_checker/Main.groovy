package truststore_checker

import javax.net.ssl.HttpsURLConnection

/**
 * @author Jonatan Ivanov
 */
class Main {
    static void main(String[] args) {
        CliBuilder cli = new CliBuilder(usage: "java -jar truststore-checker.jar <options>", width: 250)
        cli.with {
            _ longOpt: 'url', args: 1, required: true, argName: 'url', ''
            _ longOpt: 'trustStore', args: 1, required: true, argName: 'trustStore', ''
            _ longOpt: 'trustStorePassword', args: 1, required: true, argName: 'trustStorePassword', ''
        }

        OptionAccessor options = cli.parse(args)
        if (options == null) System.exit(1)

        System.setProperty('javax.net.ssl.trustStore', options.trustStore)
        System.setProperty('javax.net.ssl.trustStorePassword', options.trustStorePassword)
        HttpsURLConnection.setDefaultHostnameVerifier({ hostname, session -> true })

        println options.url.toURL().text
    }
}
