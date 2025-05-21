package model;

public class Admin extends Usuario{
    public Admin(int id, String nome, String email, String senha, Papel papel) {
        super(id, nome, email, senha, papel);
    }
}
