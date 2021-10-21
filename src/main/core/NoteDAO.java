package com.hoytnote.note.core;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.lucene.queryparser.classic.QueryParser;

import java.io.IOException;
import java.util.Arrays;

@Component
public class NoteDAO {
    @Autowired
    private IndexWriter writer;

    private final IndexReader reader;

    private final IndexSearcher searcher;

    public NoteDAO(@Autowired IndexReader reader) {
        this.reader = reader;
        this.searcher = new IndexSearcher(reader);
    }

    public String createNote(Note note) throws IOException {
        // make a new, empty document
        Document doc = new Document();

        Field pathField = new StringField("name", note.title(), Field.Store.YES);
        doc.add(pathField);

        long created_at = System.currentTimeMillis();

        doc.add(new LongPoint("created_at", created_at));
        doc.add(new StoredField("created_at", created_at));
        doc.add(new TextField("content", note.content(), Field.Store.YES));

        writer.addDocument(doc);
        writer.commit();

        return "success";
    }

    public String searchNote(String keyword) throws IOException, ParseException {

        Analyzer analyzer = new StandardAnalyzer();
        QueryParser parser = new QueryParser("content", analyzer);

        Query query = parser.parse(keyword);

        System.out.println("query = " + query);

//        TopDocs results = searcher.search(query, 10);
//        MatchAllDocsQuery allDocsQuery = new MatchAllDocsQuery();
        TopDocs results = searcher.search(query, 10);
        ScoreDoc[] hits = results.scoreDocs;
        System.out.println("hits.length = " + hits.length);
        Arrays.stream(hits).forEach(System.out::println);

        StringBuilder builder = new StringBuilder();
        builder.append("result: \n");

        if (hits.length > 0) {
            for (int i = 0; i < hits.length; i++) {
                Document doc = searcher.doc(hits[i].doc);
                doc.getFields().forEach((item) -> {
                    System.out.println("item = " + item);
                    builder.append(item.name());
                    builder.append(":");
                    builder.append(item.stringValue());
                    builder.append("\n");
                });
            }
        }

        return builder.toString();
    }
}
