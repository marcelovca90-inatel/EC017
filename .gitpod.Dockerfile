FROM gitpod/workspace-full-vnc

RUN set -ex; \
    sudo apt-get update; \
    sudo apt-get install -y python3-tk
