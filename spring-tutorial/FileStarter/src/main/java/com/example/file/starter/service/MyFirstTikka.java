package com.example.file.starter.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.tika.Tika;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BasicContentHandlerFactory;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class MyFirstTikka {
    public void process(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                List<File> files = Arrays.asList(Objects.requireNonNull(file.listFiles()));
                Tika tika = new Tika();
                Metadata metadata = new Metadata();
                files.forEach(f -> {
                    try {
                        printContent(parseUsingAutoDetect(f, tika, TikaConfig.getDefaultConfig(), metadata));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                try {
//            printContent(parseUsingAutoDetect(file, new Tika(), TikaConfig.getDefaultConfig(), new Metadata()));
                    printContent(parseUsingComponent(file, new Tika(), TikaConfig.getDefaultConfig(), new Metadata()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public String parseUsingAutoDetect(File file, Tika tika, TikaConfig tikaConfig,
                                       Metadata metadata) throws Exception {
        System.out.println("Handling using AutoDetectParser: [" + file.getName() + "]");


//       Parser parser =  tikaConfig.getParser();
        BasicContentHandlerFactory basicContentHandlerFactory = new BasicContentHandlerFactory(BasicContentHandlerFactory.HANDLER_TYPE.TEXT, -1);
        AutoDetectParser parser = new AutoDetectParser();

        ContentHandler handler = basicContentHandlerFactory.getNewContentHandler();
//        BodyContentHandler bodyContentHandler = new BodyContentHandler(-1);
        ParseContext parseContext = new ParseContext();
//        parseContext.set(EmbeddedDocumentExtractor.class,new );
        parseContext.set(Parser.class, parser);
        TikaInputStream stream = TikaInputStream.get(file.toPath(), metadata);
//        metadata.add(Metadata.CONTENT_ENCODING, "UTF-8");
        parser.parse(stream, handler, metadata, parseContext);


        System.out.println(tika.detect(file));
        System.out.println(tika.parseToString(file));
        System.out.println("Detected Charset: " + metadata.get("Content-Encoding"));

        Arrays.asList(metadata.names()).forEach(name -> System.out.println(name + " :  " + metadata.get(name)));
        return handler.toString();
    }


    private String parseUsingComponent(File file, Tika tika, TikaConfig tikaConfig, Metadata metadata) throws Exception {
        MimeTypes mimeRegistry = tikaConfig.getMimeRepository();
        metadata.set(TikaCoreProperties.RESOURCE_NAME_KEY, file.getName());
        System.out.println("The MIME type (based on filename) is: [" + mimeRegistry.detect(null, metadata) + "]");
        InputStream stream = TikaInputStream.get(file.toPath());
        System.out.println("The MIME type (based on MAGIC) is: [" + mimeRegistry.detect(stream, metadata) + "]");
        Detector detector = tikaConfig.getDetector();
        System.out.println("The MIME type (based on the Detector interface) is: [" + detector.detect(stream, metadata) + "]");
        Parser parser = tikaConfig.getParser();
        // Tell it what we think the content is
        MediaType type = detector.detect(stream, metadata);
        metadata.set(Metadata.CONTENT_TYPE, type.toString());
        // Have the file parsed to get the content and metadata
        ContentHandler handler = new BodyContentHandler();
        parser.parse(stream, handler, metadata, new ParseContext());

        if (StringUtils.isEmpty(handler.toString())) System.out.println("Empty String");
        return handler.toString();

    }

    private String getContentHandler(File file, Tika tika, TikaConfig tikaConfig, Metadata metadata) throws IOException, TikaException, SAXException {

        BodyContentHandler handler = new BodyContentHandler(-1);
        ParseContext context = new ParseContext();
        FileInputStream inputStream = new FileInputStream(file);
        Parser parser = tikaConfig.getParser();
        parser.parse(inputStream, handler, metadata, context);
        return handler.toString();
    }

    private String getContentHandlerAsByteArray(File file, Tika tika, TikaConfig tikaConfig, Metadata metadata) throws IOException, TikaException, SAXException {


        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler(Integer.MAX_VALUE);
        InputStream inputstream = new ByteArrayInputStream(Files.readAllBytes(file.toPath()));
        ParseContext context = new ParseContext();

        parser.parse(inputstream, handler, metadata, context);
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println("Header " +name + ": " + metadata.get(name));
        }
        return tika.parseToString(inputstream);
    }

    private void printContent(String content) {
        System.out.println("content :" + content);
    }
}
