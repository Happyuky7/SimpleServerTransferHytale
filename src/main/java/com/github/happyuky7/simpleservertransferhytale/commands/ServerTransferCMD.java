package com.github.happyuky7.simpleservertransferhytale.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.OptionalArg;
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;

import javax.annotation.Nonnull;

public class ServerTransferCMD extends CommandBase {

    @Nonnull
    private final RequiredArg<String> ipPortArg;

    @Nonnull
    private final OptionalArg<PlayerRef> targetPlayerArg;

    public ServerTransferCMD() {
        super("simpleservertranfer", "Simple Server Transfer: /st <ip:port> [--targetPlayer=Name]", false);

        this.ipPortArg = this.withRequiredArg(
                "ip:port",
                "com.github.happyuky7.simpleservertransferhytale.commands.ServerTransferCMD.ipPortArg",
                ArgTypes.STRING
        );

        this.targetPlayerArg = this.withOptionalArg(
                "targetPlayer",
                "com.github.happyuky7.simpleservertransferhytale.commands.ServerTransferCMD.targetPlayer",
                ArgTypes.PLAYER_REF
        );

        this.addAliases("st", "servertransfer");
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {

        String ipPort = ctx.get(this.ipPortArg);
        if (ipPort == null || !ipPort.contains(":")) {
            ctx.sendMessage(Message.raw("[SimpleServerTransfer] Usage: /st <ip:port> OR /st <ip:port> --targetPlayer=Name"));
            return;
        }

        String[] parts = ipPort.trim().split(":");
        if (parts.length != 2) {
            ctx.sendMessage(Message.raw("[SimpleServerTransfer] Invalid format. Example: 127.0.0.1:5520"));
            return;
        }

        String ip = parts[0].trim();
        int port;

        try {
            port = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            ctx.sendMessage(Message.raw("[SimpleServerTransfer] Invalid port. Example: 127.0.0.1:5520"));
            return;
        }

        if (port < 1 || port > 65535) {
            ctx.sendMessage(Message.raw("[SimpleServerTransfer] Port out of range (1-65535)."));
            return;
        }

        // PLAYER EXECUTION
        if (ctx.isPlayer()) {
            PlayerRef player = Universe.get().getPlayer(ctx.sender().getUuid());

            if (player == null) {
                ctx.sendMessage(Message.raw("[SimpleServerTransfer] PlayerRef not found (Universe lookup failed)."));
                return;
            }

            player.sendMessage(Message.raw("[SimpleServerTransfer] Connecting to " + ip + ":" + port + "..."));
            player.referToServer(ip, port);
            return;
        }


        // CONSOLE EXECUTION
        PlayerRef target = ctx.get(this.targetPlayerArg);

        if (target == null) {
            ctx.sendMessage(Message.raw("[SimpleServerTransfer] Console requires: /st <ip:port> --targetPlayer=Name"));
            return;
        }

        target.sendMessage(Message.raw("[SimpleServerTransfer] You were sent to " + ip + ":" + port + "..."));
        target.referToServer(ip, port);
    }
}
