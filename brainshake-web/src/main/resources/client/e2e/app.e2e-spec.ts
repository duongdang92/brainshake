import { BrainshakeWebPage } from './app.po';

describe('brainshake-web App', () => {
  let page: BrainshakeWebPage;

  beforeEach(() => {
    page = new BrainshakeWebPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
