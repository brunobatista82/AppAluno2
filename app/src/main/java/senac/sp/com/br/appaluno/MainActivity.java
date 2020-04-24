package senac.sp.com.br.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criando o banco de dados
            SQLiteDatabase bd = openOrCreateDatabase("dbAluno",MODE_PRIVATE,null);

            //Criando tabela do banco
            bd.execSQL("CREATE TABLE IF NOT EXISTS tbAluno(nome VARCHAR, email VARCHAR, telefone VARCHAR)");

            // Inserindo valores na tabela
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Bruno','bruno@hotmail.com','91234-5678')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Carlos','carlos@gmail.com','92345-8765')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Antonio','antonio@hotmail.com','99190-9091')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Helio','helio@gmail.com','98765-9878')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Mike','mike@hotmail.com','95678-8213')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Julia','julia@gmail.com','94528-5696')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Maria','maria@hotmail.com','93249-1234')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Paula','paula@gmail.com','95030-8060')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Flavia','flavia@hotmail.com','92145-9293')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,tefone)VALUES('Renato','renato@hotmail.com','98978-1982')");

            //Buscando dados na tabela
            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone tbAluno", null);

            // Qual a coluna que esta pegando os valores
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            //Vai guiar o cursor para frente da tabela inteira
            cursor.moveToFirst();

            while (cursor != null){
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));
                //Guiar o cursor para frente de cada registro
                cursor.moveToNext();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
