package br.com.moryta.hungry4pizza;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout tilLogin;
    private TextInputLayout tilSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilLogin = (TextInputLayout) findViewById(R.id.tilLogin);
        tilSenha = (TextInputLayout) findViewById(R.id.tilSenha);
    }

    public void logar(View view) {
        String login = tilLogin.getEditText().getText().toString();
        String senha = tilSenha.getEditText().getText().toString();

        if (!"FIAP".equals(login)) {
            tilLogin.setError("Usuário inválido");
            tilSenha.setError(null);
            return;
        } else {
            tilLogin.setError(null);
        }

        if (!"12345".equals(senha)) {
            tilSenha.setError("Senha inválida");
            return;
        } else {
            tilSenha.setError(null);
        }

        Intent intent = new Intent(this, PedidoActivity.class);
        intent.putExtra("usuario", login);

        startActivity(intent);
    }
}
