# AppNews Kotlin

Aplicativo Android que recebe dados da ***News API*** e exibe as notícias em lista.

Para o desenvolvimento desse aplicativo, foi utilizado:
+ [News API](https://newsapi.org)
+ [Kotlin](https://kotlinlang.org)
+ [Coroutines](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAiAo5qABhBdEiwAOtGmbvyr0ukd-jlKwfu5vfgBcU1I0YcPDpfNwO8D2GWWAvE2FWGMrgigoRoCLAsQAvD_BwE&gclsrc=aw.ds)
+ [Retrofit](https://square.github.io/retrofit/)
+ [Room](https://developer.android.com/training/data-storage/room)
+ [MVP Architecture](https://pt.wikipedia.org/wiki/Model-view-presenter)
+ [FAcebook Shimmer](https://github.com/facebook/shimmer-android)

## Arquitetura MVP

Em MVP a camada ***Presenter*** assume a função de mediadora. A ***View*** é responsável por manipular os eventos UI. Finalmente, a ***Model*** se torna estritamente um modelo de domínio.

![mvp](https://user-images.githubusercontent.com/45218570/105050872-fb982a80-5a4c-11eb-8afd-66e2e723686e.png)



## Configurações do Projeto

Para executar o projeto em seu dispositivo, é necessário realizar o cadastro no site [News API](https://newsapi.org) e obter a chave da api ***(API_KEY)***.
Em seguida, substitua o conteúdo na classe ***Constants***.


## Telas

  ***SplashScreen***           
  :-------------------------:
  
  Tela de carregamento do aplicativo, que conta com um sistema de verificação de conectividade com internet.
  
  <div align="left">
  <a href="https://www.linkedin.com/in/raulsarai/" target="_blank">
    <img src="https://user-images.githubusercontent.com/81999143/190030553-a859967d-072b-45f1-9d2b-dfb2270078d3.png" width="300" height="600" alt="linkedin logo"  />
  </a>
  <a href="https://www.facebook.com/raul.msarai" target="_blank">
    <img src="https://user-images.githubusercontent.com/81999143/190029862-57a43306-bba8-4f5e-ae79-834f82a49772.png" width="300" height="600" alt="facebook logo"  />
  </a>
</div>


# ---------------------------------------------------

  ***Tela Inicial***  
  :-------------------------:
  
  
  Na tela inicial, temos o carregamento de todas as notícias retornadas pela API sem filtragem.
  
  <div align="left">
  <a href="https://www.linkedin.com/in/raulsarai/" target="_blank">
    <img src="https://user-images.githubusercontent.com/81999143/190029903-77ff743f-1ddd-4265-addc-c2ba402dd155.png" width="300" height="600" alt="linkedin logo"  />
  </a>
</div>



# -----------------------------------------------------
  ***WebView Noticias***          
  :-------------------------:
  
  Na tela de WebView é possivel ler a notícia inteira, além de ser possível também salvar nos FAVORITOS.
  <div align="left">
  <a href="https://www.linkedin.com/in/raulsarai/" target="_blank">
    <img src="https://user-images.githubusercontent.com/81999143/190029928-dbf01593-228d-4113-a2f0-a6862af3f437.png" width="300" height="600" alt="linkedin logo"  />
  </a>
</div>



# -----------------------------------------------------
  ***Pesquisa***        
  :-------------------------:
  
  Na pesquisa, serão filtradas as notícias da API de acordo com o texto digitado e caso a notícia tenha a palavra-chave é retornada no mesmo instante.
  <div align="left">
  <a href="https://www.linkedin.com/in/raulsarai/" target="_blank">
    <img src="https://user-images.githubusercontent.com/81999143/190029956-bea7feec-d6f4-4014-9216-236d1c9f1681.png" width="300" height="600" alt="linkedin logo"  />
  </a>
</div>



# -----------------------------------------------------
  ***Favoritos***        
  :-------------------------:
  
  Em favoritos, pode-se ler a notícia salva anteriormente. Ao realizar o slide para o lado do card da notícia, 
  a mesma será deleta tendo ainda a opção de ser recuperada enquanto estiver na mesma tela.
  <div align="left">
  <a href="https://www.linkedin.com/in/raulsarai/" target="_blank">
    <img src="https://user-images.githubusercontent.com/81999143/190029971-c91b68ed-8b89-4fce-8a33-ba5949d71b09.png" width="300" height="600" alt="linkedin logo"  />
  </a>
</div>

 

## TO DO

Esse projeto está em construção. Será necessário adicionar:

+ [Testes Unitários](https://www.androidpro.com.br/blog/desenvolvimento-android/criando-testes-para-seu-aplicativo-android/)
+ [Testes de Instrumentação](https://www.androidpro.com.br/blog/desenvolvimento-android/criando-testes-para-seu-aplicativo-android/)
+ [CI](https://medium.com/android-dev-br/configurando-ci-cd-com-github-actions-e-firebase-app-distribution-para-projetos-android-8df02096610b)
+ [Publicação na Play Store](https://medium.com/android-dev-br/configurando-ci-cd-com-github-actions-e-firebase-app-distribution-para-projetos-android-8df02096610b)

