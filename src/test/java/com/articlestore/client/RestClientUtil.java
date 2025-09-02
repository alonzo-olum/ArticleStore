package com.articlestore.client;

import com.articlestore.entity.Article;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;

public class RestClientUtil {

    public void getArticleByIdDemo() {
	    String url = "http://localhost:8080/user/article/{id}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Article> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article.class, 1);

        Article article = responseEntity.getBody();
        assert article != null;
        System.out.println("Id:"+article.getArticleId()+", Title:"+article.getTitle()
                 +", Category:"+article.getCategory());      
    }

	public void getAllArticlesDemo() {
        String url = "http://localhost:8080/user/articles";

        RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Article[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article[].class);
        Article[] articles = responseEntity.getBody();

        for (Article article : articles) {
            System.out.println("Id:" + article.getArticleId() + ", Title:" + article.getTitle()
                    + ", Category: " + article.getCategory());
        }
    }

    public void addArticleDemo() {
        String url = "http://localhost:8080/user/article";

        RestTemplate restTemplate = new RestTemplate();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);

	    Article obj = new Article();
	    obj.setTitle("Spring REST Security using Hibernate");
	    obj.setCategory("Spring");

        HttpEntity<Article> requestEntity = new HttpEntity<>(obj, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(Objects.requireNonNull(uri).getPath());
    }

    public void updateArticleDemo() {
        String url = "http://localhost:8080/user/article";

        RestTemplate restTemplate = new RestTemplate();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);

	    Article obj = new Article();
	    obj.setArticleId(1);
	    obj.setTitle("Update:Java Concurrency");
	    obj.setCategory("Java");

        HttpEntity<Article> requestEntity = new HttpEntity<>(obj, headers);
        restTemplate.put(url, requestEntity);
    }

    public void deleteArticleDemo() {
        String url = "http://localhost:8080/user/article/{id}";

        RestTemplate restTemplate = new RestTemplate();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Article> requestEntity = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 1);        
    }

    public static void main(String[] args) {
    	RestClientUtil util = new RestClientUtil();
        util.getArticleByIdDemo();
    	util.addArticleDemo();
    	util.updateArticleDemo();
    	util.deleteArticleDemo();
    	util.getAllArticlesDemo();    	
    }    
}
