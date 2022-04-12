package anchor.book.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "series")
public class Series {
    @Id @GeneratedValue
    @Column(name = "series_id")
    private long id;

    @Column(name = "series_name")
    private String name;
}
