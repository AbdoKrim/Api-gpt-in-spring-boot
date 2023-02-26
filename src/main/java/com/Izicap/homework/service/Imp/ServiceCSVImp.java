package com.Izicap.homework.service.Imp;

import com.Izicap.homework.model.ChatMessage;
import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.Response;
import com.Izicap.homework.service.ServiceCSV;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.concurrency.SingletonMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.message.Message;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ServiceCSVImp implements ServiceCSV {
    private static int contConv=0;

    public ServiceCSVImp() throws IOException {
    }

    public void addToCsv(Request request, Response response) throws IOException {

        String resp = response.getResponse().replaceAll("[-+.^:,`,\n,`\t,;]"," ");

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/csv/chat.csv",true))) {
            ClassPathResource classPathResource = new ClassPathResource("csv/chat.csv");
            StringBuilder sb = new StringBuilder();
            List<String> lines = Files.readAllLines(Path.of(classPathResource.getURI()));
            System.out.println(lines.size());

            if(lines.size()==0 && contConv==0){
                sb.append("Question");
                sb.append(';');
                sb.append("Answer");
                sb.append('\n');
            }
            sb.append(request.getMessage());
            sb.append(';');
            sb.append(resp);
            sb.append('\n');

            writer.write(sb.toString());
            writer.close();
            System.out.println("done!");
            contConv++;


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
       /* String result = response.getResponse().replaceAll("[-+.^:,`,\n,`\t,]"," ");

        ChatMessage message = new ChatMessage(request.getMessage(), result);
        try (Writer writer = new FileWriter("src/main/resources/csv/chat.csv", true)) {
            StatefulBeanToCsv<ChatMessage> beanToCsv = new StatefulBeanToCsvBuilder<ChatMessage>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                    .withLineEnd(CSVWriter.DEFAULT_LINE_END).build();

            beanToCsv.write(message);

        } catch (CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }


    }*/}
