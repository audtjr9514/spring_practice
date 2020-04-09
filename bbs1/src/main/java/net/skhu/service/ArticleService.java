package net.skhu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Article;
import net.skhu.domain.Board;
import net.skhu.domain.User;
import net.skhu.model.ArticleModel;
import net.skhu.model.Option;
import net.skhu.model.Pagination;
import net.skhu.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired ArticleRepository articleRepository;
	
	public Article findOne(int id) {
		return articleRepository.findById(id).get();
	}
	
	public List<Article> findAll(Pagination pagination){
		return articleRepository.findAll(pagination);
	}
	
	public void update(ArticleModel a) {
		articleRepository.update(a.getId(), a.getTitle(), a.getBody());
	}
	
	public int insertArticle(ArticleModel a, int boardId, int userId) {
		int maxNo = articleRepository.findMaxNo(boardId);
		
		Article article = new Article();
		article.setBoard(new Board());
		article.getBoard().setId(boardId);
		article.setUser(new User());
		article.getUser().setId(userId);
		article.setWriteTime(new Date());
		article.setNo(maxNo + 1);
		article.setTitle(a.getTitle());
		article.setBody(a.getBody());
		articleRepository.save(article);
		return article.getId();
	}
	
	public void delete(int id) {
		articleRepository.deleteById(id);
	}
	
	public Option[] getOrderByOptions() {
		return ArticleRepository.orderBy;
	}
	
	public Option[] getSearchByOptions() {
		return ArticleRepository.searchBy;
	}
	
}
