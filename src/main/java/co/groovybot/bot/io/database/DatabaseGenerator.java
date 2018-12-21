package co.groovybot.bot.io.database;

public class DatabaseGenerator {

    public DatabaseGenerator(PostgreSQL postgreSQL) {
        postgreSQL.addDefault(() -> "create table if not exists guilds\n" +
                "(\n" +
                "  id                   bigint                not null\n" +
                "    constraint guilds_pkey\n" +
                "    primary key,\n" +
                "  prefix               varchar,\n" +
                "  volume               integer,\n" +
                "  dj_mode              boolean default false not null,\n" +
                "  announce_songs       boolean default true,\n" +
                "  blacklisted_channels varchar default '[]' :: character varying,\n" +
                "  commands_channel     bigint,\n" +
                "  auto_leave           boolean default true  not null,\n" +
                "  auto_pause           boolean default false  not null\n" +
                "  auto_join_channel    bigint default null\n" +
                ");");

        postgreSQL.addDefault(() -> "create table if not exists keys\n" +
                "(\n" +
                "  id   serial not null\n" +
                "    constraint keys_pkey\n" +
                "    primary key,\n" +
                "  type varchar,\n" +
                "  key  varchar\n" +
                ");");

        postgreSQL.addDefault(() -> "create table if not exists lavalink\n" +
                "(\n" +
                "  uri      varchar not null\n" +
                "    constraint lavalink_nodes_pkey\n" +
                "    primary key,\n" +
                "  password varchar\n" +
                ");");

        postgreSQL.addDefault(() -> "create table if not exists playlists\n" +
                "(\n" +
                "  id        bigint\n" +
                "    constraint playlists_pk\n" +
                "    unique,\n" +
                "  author_id bigint,\n" +
                "  name      varchar,\n" +
                "  public    boolean default false not null,\n" +
                "  tracks    varchar,\n" +
                "  count     integer default 0     not null\n" +
                ");");

        postgreSQL.addDefault(() -> "create table if not exists premium\n" +
                "(\n" +
                "  user_id       bigint                                      not null\n" +
                "    constraint premium_pkey\n" +
                "    primary key,\n" +
                "  patreon_token varchar,\n" +
                "  type          varchar default 'NONE' :: character varying not null,\n" +
                "  \"check\"       boolean default true                        not null,\n" +
                "  refresh_token varchar,\n" +
                "  patreon_id    varchar\n" +
                ");");

        postgreSQL.addDefault(() -> "create table if not exists queues\n" +
                "(\n" +
                "  guild_id         bigint              not null\n" +
                "    constraint table_name_pkey\n" +
                "    primary key,\n" +
                "  current_track    varchar,\n" +
                "  current_position bigint,\n" +
                "  queue            varchar,\n" +
                "  channel_id       bigint,\n" +
                "  text_channel_id  bigint,\n" +
                "  volume           integer default 100 not null\n" +
                ");");

        postgreSQL.addDefault(() -> "create table if not exists users\n" +
                "(\n" +
                "  user_id    bigint                not null\n" +
                "    constraint users_pkey\n" +
                "    primary key,\n" +
                "  locale     varchar(50),\n" +
                "  friend     boolean default false not null,\n" +
                "  expiration bigint default 0      not null,\n" +
                "  again      bigint default 0      not null\n" +
                ");");

        postgreSQL.addDefault(() -> "create table if not exists websocket\n" +
                "(\n" +
                "  token varchar(64) not null\n" +
                "    constraint websocket_pkey\n" +
                "    primary key\n" +
                ");");

        postgreSQL.createDatabases();
    }
}
