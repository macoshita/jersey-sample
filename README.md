# jersey-sample

JAX-RS Jersey + Tomcat or Jetty + Gradleのごく小さなサンプルです

## 動かし方

```sh
git clone https://github.com/mirutover/jersey-sample.git
cd jersey-sample
gradlew tomcatRun
```

デプロイ先としては、beanstalkで動作確認できています

## ハマったところ

- jersey 1.x系の情報に惑わされた
  - 現時点の最新は2.4。結構オプション名とか変わってる。特に、web.xmlの書き方が変わってるので注意。
- jerseyの依存関係がよく分からなくてハマった
  - 結論から言えば、jersey-container-servlet = Jersey Core + Servlet 3.0なので、tomcatやjettyで動かしたいだけならこれさえ追加してればOK
  - <https://jersey.java.net/documentation/latest/user-guide.html#modules-and-dependencies>

## 問題点

- jettyはjettyRun + 別のコンソールでcompileJavaすればリロードされるんだけど、tomcatはされない。
  - gradle tomcat pluginではreloadableってオプションがあるから、動くはずなんだけども……

## 参考

いろんなサイトを参考にさせて頂きました。

- <http://kakakikikeke.blogspot.jp/2013/08/javajersey22tomcateclipsemavenapi.html>
- <http://www.glamenv-septzen.net/view/1165>
