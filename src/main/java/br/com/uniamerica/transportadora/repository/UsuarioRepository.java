package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.Grupo;
import br.com.uniamerica.transportadora.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findByAtivoTrue();
    @Query(value = "select * from transportadora.tb_usuario " + "where nome ilike '%' || :nome || '%'", nativeQuery = true)
    public List<Usuario> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);
    public List<Usuario> findByPercGanho(final BigDecimal percGanho);
    public List<Usuario> findByLogin(final String login);
    public List<Usuario> findBySenha(final String senha);
    public List<Usuario> findByGrupo(final Grupo grupo);
    public List<Usuario> findByNome(final String nome);
    public List<Usuario> findByCpf(final String cpf);
    public List<Usuario> findByTelefone(final String telefone);
    public List<Usuario> findByDataNascimento(final Date dataNascimento);
    public List<Usuario> findByEndereco(final String endereco);
    public List<Usuario> findByObservacao(final String observacao);
}
