package com.hoytnote.note.core;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Paths;

@Component
public class NoteConfig {
    @Value("${indexPath}")
    private String indexPath;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    private IndexWriter writer() throws IOException {
        Directory dir = FSDirectory.open(Paths.get(indexPath));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
//        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        iwc.setUseCompoundFile(false);
        return new IndexWriter(dir, iwc);
    }
//
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    private IndexSearcher searcher() throws IOException {
//        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
//        return new IndexSearcher(reader);
//    }
//
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    private IndexReader reader(@Autowired IndexWriter writer) throws IOException {
        return DirectoryReader.open(writer);
    }

    @PreDestroy
    private void close() throws IOException {
        System.out.println("pre destroy called");
    }
}
