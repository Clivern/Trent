# Buid Dirs Structure
cd /var
mkdir www
cd www
mkdir trent
cd trent

# Install Java
sudo apt-get update
sudo apt-get install default-jdk

# Install unzip
sudo apt-get install unzip

# Install git
sudo apt-get install git

# Install sbt
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
sudo apt-get update
sudo apt-get install sbt

# Install MySQL & Create Database
sudo apt-get install mysql-server
sudo mysql_secure_installation
echo "create database trent" | mysql -u root -p

# Clone & Run Trent
git clone https://github.com/Clivern/Trent.git .
sbt "run 80"