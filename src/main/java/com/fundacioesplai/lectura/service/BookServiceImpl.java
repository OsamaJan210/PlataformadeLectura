    package com.fundacioesplai.lectura.service;

    import java.util.ArrayList;
    import java.util.List;

    import org.springframework.stereotype.Service;

    import com.fundacioesplai.lectura.model.Book;
    import com.fundacioesplai.lectura.model.BooksStatus;
    import com.fundacioesplai.lectura.repository.BookRepo;
    import com.fundacioesplai.lectura.repository.BooksStatusRepository;

    import jakarta.persistence.EntityManager;
    import jakarta.persistence.PersistenceContext;
    import jakarta.persistence.TypedQuery;
    import lombok.AllArgsConstructor;

@Service("BookService")
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final BooksStatusRepository booksStatusRepo; // corregido

    @PersistenceContext
    private EntityManager entityManager;

    @Override 
    public Book createBook(Book req){
        try {
            return bookRepo.save(req);
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> search(String keyword, Integer genreId, Integer statusId, Integer formatId) {
        StringBuilder jpql = new StringBuilder("SELECT b FROM Book b");
        List<String> conditions = new ArrayList<>();

        if (genreId != null) {
            conditions.add("b.genre.id = :genreId");
        }
        if (formatId != null) {
            conditions.add("b.format.id = :formatId");
        }

        if (!conditions.isEmpty()) {
            jpql.append(" WHERE ").append(String.join(" AND ", conditions));
        }

        TypedQuery<Book> query = entityManager.createQuery(jpql.toString(), Book.class);

        if (genreId != null) {
            query.setParameter("genreId", genreId);
        }
        if (formatId != null) {
            query.setParameter("formatId", formatId);
        }

        return query.getResultList();
    }

    @Override 
    public BooksStatus addStatusByUser(BooksStatus req){
        try {
            return booksStatusRepo.save(req);
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksStatus> statusByBookIdanduserId(BooksStatus req){
        return booksStatusRepo.findByUser_IdAndBook_Id(req.getUser().getId(), req.getBook().getId());
    }

    @Override
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }
}
