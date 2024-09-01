# git与github

1. 安装git   git --version 查看安装的git版本号

2. git中的几个简单概念

   ​     git init  创建工作区

   ​     git commit   提交暂存区

   ​     git push  推送远端仓库

3. github是一个代码托管远端仓库，可以拉取github上的代码到本地仓库，也可以将我们本地的代码提交叫github上托管起来

4. 基于以上，需要弄清楚github与本地git的通信和认证

    假设已经有了github账号，创建一个仓库并有代码，此时我们想将这个仓库的代码下载到本地。

   

   本地git添加用户名和邮箱

   git config –global user.name ‘xxxxx’ 
   git config –global user.email ‘xxx@xx.xxx’
   
   
   
   github支持两种认证方式将代码拉取到本地
   
   https://github.com/xxxxx/xxxxxxx.git
   
   git@github.com:xxxxxxx/xxxxxx.git
   
   官方推荐https方式拉取代码
   
   使用https方式拉取代码，本地无需做任何配置，只需要git clone时输入github的用户名和密码即可
   
   还可以采取ssh的方式，当采取ssh方式连接github时，需要在本地创建一对密钥，将私钥存在本地，公钥放入远端github账户
   
   
   
   创建密钥对命令
   
   ssh-keygen -t rsa -b 4096 -C “your_email@example.com”
   
   需要指出的是，创建密钥的时候，可以选择保留 passphrase（密钥口令）或者留空。如果留空，则可以无需输入口令就能访问密钥。
   
   Windows密钥对会存放在/C/Users/YourUsername/.ssh/id_rsa目录下，而Linux和macOS系统密钥会保存在~/.ssh/id_rsa
   
   将id_rsa.pub公钥拷贝到git仓库中，即可实现ssh方式通信
   
   
   
   
   
   
   
   
   
   