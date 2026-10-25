FROM mcr.microsoft.com/devcontainers/java:1-21-bookworm

USER root

RUN apt-get update && apt-get install -y \
    maven curl jq unzip ca-certificates \
    fonts-liberation xdg-utils \
    libnss3 libatk-bridge2.0-0 libatk1.0-0 libatspi2.0-0 \
    libcups2 libdrm2 libxkbcommon0 libxcomposite1 libxdamage1 \
    libxfixes3 libxrandr2 libgbm1 libasound2 libpango-1.0-0 \
    libcairo2 libx11-xcb1 libxcb1 libx11-6 libxext6 \
    libxshmfence1 libglib2.0-0 libfontconfig1 \
    && curl -fsSL \
       https://googlechromelabs.github.io/chrome-for-testing/last-known-good-versions-with-downloads.json \
       -o /tmp/chrome-versions.json \
    && CHROME_URL=$(jq -r '.channels.Stable.downloads.chrome[] | select(.platform=="linux64") | .url' /tmp/chrome-versions.json) \
    && DRIVER_URL=$(jq -r '.channels.Stable.downloads.chromedriver[] | select(.platform=="linux64") | .url' /tmp/chrome-versions.json) \
    && curl -fsSL "$CHROME_URL" -o /tmp/chrome.zip \
    && curl -fsSL "$DRIVER_URL" -o /tmp/chromedriver.zip \
    && unzip -q /tmp/chrome.zip -d /opt/ \
    && unzip -q /tmp/chromedriver.zip -d /opt/ \
    && ln -sf /opt/chrome-linux64/chrome /usr/local/bin/google-chrome \
    && ln -sf /opt/chromedriver-linux64/chromedriver /usr/local/bin/chromedriver \
    && rm -f /tmp/chrome-versions.json /tmp/chrome.zip /tmp/chromedriver.zip \
    && rm -rf /var/lib/apt/lists/*

USER vscode
