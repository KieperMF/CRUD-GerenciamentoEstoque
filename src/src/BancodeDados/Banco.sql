create database Loja;
use Loja;

create table Admin(
usuarioId int(11) primary key auto_increment not null,
nome varchar(100) not null,
senha varchar(100) not null
);

create table Vendedor(
usuarioId int(11) primary key auto_increment not null,
nome varchar(100) not null,
senha varchar(100) not null
);

create table Produto(
produtoId int(11) primary key auto_increment not null,
nome varchar(200) not null,
descricao varchar(250) not null,
precoUnitario double not null,
estoque int 
);

