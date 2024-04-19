#! /usr/bin/env groovy

import javax.net.ssl.HttpsURLConnection
import groovy.cli.picocli.CliBuilder
import groovy.cli.picocli.OptionAccessor

/**
 * @author Jonatan Ivanov
 */
CliBuilder cli = new CliBuilder(usage: "${this.class.simpleName}.groovy <options>", width: 250)
cli.with {
    h longOpt: 'help', 'Show usage information'
    _ longOpt: 'url', args: 1, required: true, argName: 'url', ''
    _ longOpt: 'trustStore', args: 1, required: true, argName: 'trustStore', ''
    _ longOpt: 'trustStorePassword', args: 1, required: true, argName: 'trustStorePassword', ''
    _ longOpt: 'verbose', ''
}

OptionAccessor options = cli.parse(args)
if (options == null || options.h) {
    System.exit(1)
}

if (options.verbose) System.setProperty('javax.net.debug', 'all')
System.setProperty('javax.net.ssl.trustStore', options.trustStore)
System.setProperty('javax.net.ssl.trustStorePassword', options.trustStorePassword)
HttpsURLConnection.setDefaultHostnameVerifier({ hostname, session -> true })

println options.url.toURL().text
