package  edu.mum.cs544.Domain;

import javax.persistence.*;

@Entity
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category userInterest;

    @ManyToOne
    private User user;

    public Interest() {
    }

    public Interest(Long id, Category userInterest, User user) {
        this.id = id;
        this.userInterest = userInterest;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(Category userInterest) {
        this.userInterest = userInterest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
