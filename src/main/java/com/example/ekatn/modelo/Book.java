package com.example.ekatn.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name="book")
@NamedQueries({
        @NamedQuery(name = "Book.findAdll", query = "SELECT p FROM Book p")
        ,@NamedQuery(name = "Book.findByIdbooks", query="SELECT p FROM Book p WHERE p.idBooks = :idBooks")
        ,@NamedQuery(name = "Book.findByNombre", query="SELECT p FROM Book p WHERE p.nombre = :nombre")
        ,@NamedQuery(name = "Book.findByAutor", query="SELECT p FROM Book p WHERE p.autor = :autor")
})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) //representa que este campo es obligatorio en base de datos
    @Column(name ="idBooks")
    private Integer idBooks;

    @Basic(optional = false)
    @Column(name ="nombre")
    private String nombre;

    @Column(name="autor")
    private String autor;



    public  Book(){
    }

    public Book(Integer idBooks, String nombre){
        this.idBooks = idBooks;
        this.nombre = nombre;
    }

    public Book(String nombre, String autor) {
        super();
        this.nombre = nombre;
        this.autor = autor;
    }



	public Integer getIdBooks() {
		return idBooks;
	}

	public void setIdBooks(Integer idBooks) {
		this.idBooks = idBooks;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBooks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(idBooks, other.idBooks);
	}

	@Override
	public String toString() {
		return "Book [idBooks=" + idBooks + "]";
	}

    public Book buscarPorID(int i) {
        return null;
    }
    
    
    
    
    
}
