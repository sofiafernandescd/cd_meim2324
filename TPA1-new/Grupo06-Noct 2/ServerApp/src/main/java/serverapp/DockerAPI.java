package serverapp;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class DockerAPI {
    public static void main(String[] args) {
        // arg0 windows: tcp://localhost:2375 // arg0 linux: unix:///var/run/docker.sock
        // arg1 : container name
        // arg2 : volume name or filesystem directory
        // arg3: image pathname
        // arg4: image result pathname (volume)
        // arg5 - arginf: image keywords
        try {
            // Extrair argumentos da linha de comandos
            String HOST_URI = args[0];
            String containerName = args[1];
            String pathVolDir = args[2];
            String imageName = args[3];
            List<String> command=new ArrayList<>();

            // Populating the command list with image keywords
            for (int i=4; i < args.length; i++)
                command.add(args[i]);

            // Creating a Docker client
            DockerClient dockerclient = DockerClientBuilder
                    .getInstance()
                    .withDockerHttpClient(
                            new ApacheDockerHttpClient.Builder()
                                    .dockerHost(URI.create(HOST_URI))
                                    .build())
                    .build();

            // Configuring host options for the container
            HostConfig hostConfig = HostConfig.newHostConfig()
                                                .withBinds(new Bind(pathVolDir, new Volume("/usr/datafiles")));

            // Creating a container with specified options
            CreateContainerResponse containerResponse = dockerclient
                                                .createContainerCmd(imageName)
                                                .withName(containerName)
                                                .withHostConfig(hostConfig)
                                                .withCmd(command)
                                                .exec();

            // Print the container ID
            System.out.println("ID:" + containerResponse.getId());

            // Começar o container
            dockerclient.startContainerCmd(containerResponse.getId()).exec();

            // Inspecting the container to get its status
            InspectContainerResponse inspResp = dockerclient.inspectContainerCmd(containerName).exec();
            System.out.println("Container Status: " + inspResp.getState().getStatus());

            // if If the container is running, kill it
            dockerclient.killContainerCmd(containerName).exec();

            // remove container
            dockerclient.removeContainerCmd(containerName).exec();
        } catch (Exception ex) {
            // handle exception
            ex.printStackTrace();
        }
    }
}