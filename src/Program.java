/**classe para acessar API do site IMDB que forcene arquivos JSON com informa��ess da base de dados do site*/
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Program {

	public static void main(String[] args) throws Exception {
		
		HttpRequest request;   //respons�vel por montar a requisi��o HTTP
		HttpClient client;     //respons�vel por fazer a conex�o com o destino
		HttpResponse<String> response; //respons�vel por receber a resposta do destino
		URI domain; //URL da API IMDB
		String imdbKey; //armazena a chave de acesso da API IMDB fornecida atrav�s de um arquivo
		
		//faz a leitura da chave de acesso � API IMDB em arquivo
		FileInputStream key = new FileInputStream("imdbKey");
		imdbKey = new String(key.readAllBytes());
		key.close();
		
		domain = new URI("https://imdb-api.com/en/API/Top250Movies/" + imdbKey);
		request = HttpRequest
				.newBuilder()
				.uri(domain)
				.GET()	
				.build();

		client = HttpClient
				.newBuilder()
				.build();

		response = client.send(request, BodyHandlers.ofString());
		String result = response.body();
		
		//sa�da dividida devido limita��o Console Eclipse
		System.out.println(result.substring(0,30000));
		System.out.println(result.substring(30000,60000));
		System.out.println(result.substring(60000,90000));
		System.out.println(result.substring(90000,90564));
	}

}
